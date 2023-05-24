package cl.amisoft.causaapp.service.impl;

import cl.amisoft.causaapp.client.TramiteCausaClient;
import cl.amisoft.causaapp.dao.CausaDao;
import cl.amisoft.causaapp.model.Causa;
import cl.amisoft.causaapp.service.CausaService;
import cl.amisoft.causaapp.vo.CausaVo;
import cl.amisoft.causaapp.vo.TramiteCausaVo;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CausaServiceImpl implements CausaService {

    private final CausaDao causaDao;
    private final TramiteCausaClient tramiteCausaClient;

    @Autowired
    public CausaServiceImpl(CausaDao causaDao, TramiteCausaClient tramiteCausaClient) {
        this.causaDao = causaDao;
        this.tramiteCausaClient = tramiteCausaClient;
    }

    @Override
    public CausaVo obtener(Long id) {
        Optional<Causa> causa = causaDao.obtenerCausa(id);
        if (causa.isPresent()) {
            List<TramiteCausaVo> tramitesCausa = tramiteCausaClient.obtenerTodosPorCausa(causa.get().getId());
            return new CausaVo.Builder()
                    .id(causa.get().getId())
                    .nombre(causa.get().getNombre())
                    .fechaCreacion(causa.get().getFechaCreacion())
                    .tramites(tramitesCausa)
                    .build();
        }
        return new CausaVo();
    }
}