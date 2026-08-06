package io.github.keita_yamao.maintelog.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import io.github.keita_yamao.maintelog.data.Machine;
import io.github.keita_yamao.maintelog.data.Maker;
import io.github.keita_yamao.maintelog.service.MainteLogService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<Maker> getMakerList(){
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
    
    /**
     * 機械のリストを取得する
     * @return  機械のリスト
     */
    @GetMapping("/machineList")
    public List<Machine> getMachines(){
        return mainteLogService.getMachines();
    }

    /**
     * 機械のIDから機械を取得する
     * @param id 機械のID
     * @return 機械情報
     */
    @GetMapping("/machine/{id}")
    public Machine getMachineById(@PathVariable(name="id") int id) {        
        return mainteLogService.getMachineById(id); 
    }
    
    /**
     * ロケーションIDから機械のリストを取得する
     * @param id ロケーションID
     * @return 機械情報のリスト
     */
    @GetMapping("/machines/location/{id}")
    public List<Machine> getMachinesByLocationId(@PathVariable(name="id") int id) {
        return mainteLogService.getMachinesByLocationId(id);
    }

    /**
     * 機械名から機械のリストを取得する
     * @param name 機械名
     * @return 機械情報のリスト
     */
    @GetMapping("/machines")
    public List<Machine> getMachinesByName(@RequestParam(name = "name", required = false) String name) {
        if (name == null || name.trim().isEmpty()){
            return mainteLogService.getMachines();
        }
        return mainteLogService.getMachinesByName(name);
    }
    
}
