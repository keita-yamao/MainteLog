package io.github.keita_yamao.maintelog.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import io.github.keita_yamao.maintelog.data.Maker;

/**
 * メーカー情報テーブルと紐づくリポジトリクラス。
 */
@Mapper
public interface MakersRepository {

   /**
    * メーカー情報の全件検索。
    * @return メーカー一覧(全件)
    */
   List<Maker> searchMakers();

   /**
    * 指定されたIDに一致するメーカー情報を検索。
    * @param id メーカーID
    * @return メーカー情報
    */
   Maker searchMakerById(int id);
}
