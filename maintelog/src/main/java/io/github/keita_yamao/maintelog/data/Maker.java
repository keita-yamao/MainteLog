package io.github.keita_yamao.maintelog.data;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Schema(description = "メーカー情報")
@Value
public class Maker {
    @Schema(description = "メーカーID", example = "1")
    private int id;
    @Schema(description = "メーカー名", example = "株式会社〇〇")
    @Size(max = 255)
    private String maker;
    @Schema(description = "住所", example = "東京都港区○○")
    @Size(max = 255)
    private String address;
    @Schema(description = "電話番号", example = "03-1234-5678")
    @Size(max = 20)
    private String tell;
    @Schema(description = "FAX番号", example = "03-1234-5679")
    @Size(max = 20)
    private String fax;
}
