package cl.amisoft.causaapp.client;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TramiteCausaClientFallbackFactory implements FallbackFactory<TramiteCausaClient> {

  @Override
  public TramiteCausaClient create(Throwable throwable) {
    return new TramiteCausaClientFallback(throwable);
  }
}
