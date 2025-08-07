package com.bcss.shopall.dto;

import java.util.Date;

public record ReseniaDTO(
        String descripcion,
        Date fecha,
        Long idProducto
) {
}
