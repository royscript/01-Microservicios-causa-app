package cl.amisoft.causaapp.client;

import cl.amisoft.causaapp.vo.TramiteCausaVo;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="tramite-app", fallbackFactory = TramiteCausaClientFallbackFactory.class)
@RibbonClient(name="tramite-app")
public interface TramiteCausaClient {

    @GetMapping(value = "/tramite-causa/{idCausa}", produces = "application/json")
    List<TramiteCausaVo> obtenerTodosPorCausa(@PathVariable(name = "idCausa") Long idCausa);

}
