package io.github.keita_yamao.maintelog.service;
import java.util.List;

import org.springframework.stereotype.Service;

import io.github.keita_yamao.maintelog.data.Maker;
import io.github.keita_yamao.maintelog.repository.MakersRepository;
import io.github.keita_yamao.maintelog.data.Machine;
import io.github.keita_yamao.maintelog.repository.MachinesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MainteLogService {
    private final MakersRepository makersRepository;
    private final MachinesRepository machinesRepository;

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

    /**
     * 機械情報の全件取得。
     * @return 機械一覧
     */
    public List<Machine> getMachines() {
        return machinesRepository.searchMachines(); 
    }

    /**
     * 指定されたIDに一致する機械情報を取得。
     * @param id 機械ID
     * @return 機械情報
     */
    public Machine getMachineById(int id) {
        return machinesRepository.searchMachineById(id);
    }

    /**
     * 指定されたロケーションIDに一致する機械情報を取得。
     * @param locationId ロケーションID
     * @return 機械情報のリスト
     */
    public List<Machine> getMachinesByLocationId(int locationId) {
        return machinesRepository.searchMachinesByLocationId(locationId);
    }

    /**
     * 指定された機械名に一致する機械情報を取得。
     * @param name 機械名
     * @return 機械情報のリスト
     */
    public List<Machine> getMachinesByName(String name) {
        return machinesRepository.searchMachinesByName(name);
    }

}
