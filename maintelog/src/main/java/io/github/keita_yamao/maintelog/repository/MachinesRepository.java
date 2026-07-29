package io.github.keita_yamao.maintelog.repository;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import io.github.keita_yamao.maintelog.data.Machine;

@Mapper
public interface MachinesRepository {
    /**
     * 機械情報の全件検索。
     * @return 機械一覧(全件)
     */
    public List<Machine> searchMachines();

    /**
     * 指定されたIDに一致する機械情報を検索。
     * @param id 機械ID
     * @return 機械情報
     */
    public Machine searchMachineById(int id);

    /**
     * 指定されたロケーションIDに一致する機械情報を検索。
     * @param locationId ロケーションID
     * @return 機械情報のリスト
     */
    public List<Machine> searchMachinesByLocationId(int locationId);

    /**
     * 指定された機械名に一致する機械情報を検索。
     * @param name 機械名
     * @return 機械情報のリスト
     */
    public List<Machine> searchMachinesByName(String name);
    
}
