package io.github.keita_yamao.maintelog.data;

import java.sql.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Schema(description = "機械情報")
@Value
public class Machine {
    @Schema(description = "機械ID", example = "1")
    private int id;
    @Schema(description = "設置場所ID", example = "1")
    private int locationId;
    @Schema(description = "メーカーID", example = "1")
    private int makerId;
    @Schema(description = "機械名", example = "〇〇機械")
    @Size(max = 255)
    private String machine;
    @Schema(description = "型式", example = "〇〇型式")
    @Size(max = 255)
    private String model;
    @Schema(description = "設置日", example = "2020-01-01")
    private Date installationDate;
}
