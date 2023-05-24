package cl.amisoft.causaapp.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class CausaVo implements Serializable {
    private Long id;
    private String nombre;
    private LocalDateTime fechaCreacion;
    private List<TramiteCausaVo> tramites;

    public CausaVo(Builder builder) {
        id = builder.id;
        nombre = builder.nombre;
        fechaCreacion = builder.fechaCreacion;
        tramites = builder.tramites;
    }

    public CausaVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<TramiteCausaVo> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteCausaVo> tramites) {
        this.tramites = tramites;
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private LocalDateTime fechaCreacion;
        private List<TramiteCausaVo> tramites;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder tramites(List<TramiteCausaVo> tramites) {
            this.tramites = tramites;
            return this;
        }

        public CausaVo build() {
            return new CausaVo(this);
        }
    }

}
