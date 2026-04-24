package io.github.keita_yamao.maintelog.service;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.keita_yamao.maintelog.data.Maker;
import io.github.keita_yamao.maintelog.repository.MakersRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainteLogService {
    private final MakersRepository makersRepository;

    /**
     * メーカー情報の全件取得。
     * @return メーカー一覧
     */
    public List<Maker> getMakers() {
        return makersRepository.searchMakers();
    }

    /**
     * 指定されたIDに一致するメーカー情報を取得。
     * @param id メーカーID
     * @return メーカー情報
     */
    public Maker getMakerById(int id) {
        return makersRepository.searchMakerById(id);
    }

}
