package cl.amisoft.causaapp.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "causa", schema = "pjud")
public class Causa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    public Causa() {
    }

    public Causa(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.fechaCreacion = builder.fechaCreacion;
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

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private LocalDateTime fechaCreacion;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombreTramite(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder fechaCreacion(LocalDateTime fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Causa build() {
            return new Causa(this);
        }
    }
}
