package cl.amisoft.causaapp.dao;

import cl.amisoft.causaapp.model.Causa;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CausaDao {

  @PersistenceContext
  protected EntityManager em;

  public Optional<Causa> obtenerCausa(Long id) {
    TypedQuery<Causa> query = em.createQuery("Select c from Causa c where c.id = :id", Causa.class)
        .setParameter("id", id);
    Causa c = query.getResultList().isEmpty() ? null : query.getResultList().get(0);
    return Optional.ofNullable(c);
  }
}
