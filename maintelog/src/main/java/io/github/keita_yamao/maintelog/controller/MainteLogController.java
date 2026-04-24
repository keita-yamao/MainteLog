package io.github.keita_yamao.maintelog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import io.github.keita_yamao.maintelog.data.Maker;
import io.github.keita_yamao.maintelog.service.MainteLogService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Validated
@RestController
@RequiredArgsConstructor
public class MainteLogController {
    
    private final MainteLogService mainteLogService;
    
    /**
     * メーカーのリストを取得する
     * @return  メーカーのリスト
     */
    @GetMapping("/makerList")
    public List<Maker> getMethodName(){
        return mainteLogService.getMakers();
    }

    /**
     * メーカーのIDからメーカーを取得する
     * @param id メーカーのID
     * @return メーカー情報
     */
    @GetMapping("/maker/{id}")
    public Maker getMakerById(@PathVariable(name="id") int id) {
        return mainteLogService.getMakerById(id); 
    }
    
}
