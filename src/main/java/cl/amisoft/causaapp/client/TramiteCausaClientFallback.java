package cl.amisoft.causaapp.client;

import cl.amisoft.causaapp.vo.TramiteCausaVo;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import java.util.Collections;
import java.util.List;

public class TramiteCausaClientFallback implements TramiteCausaClient {

  private final Throwable cause;

  public TramiteCausaClientFallback(Throwable cause) {
    this.cause = cause;
  }

  @Override
  public List<TramiteCausaVo> obtenerTodosPorCausa(Long idCausa) {
    if (cause instanceof HystrixTimeoutException) {
      //doSomething
    }
    return Collections.emptyList();
  }
}
