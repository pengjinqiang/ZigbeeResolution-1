package com.bupt.ZigbeeResolution.mapper;

import com.bupt.ZigbeeResolution.data.Scene;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SceneMapper {

    @Insert("INSERT INTO scene (sceneName,customerId) VALUES (#{sceneName}, #{customerId})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer addSceneOnlySceneName(Scene scene);

    @Select("SELECT * FROM scene WHERE sceneName = #{sceneName}")
    Scene getSceneByName(@Param("sceneName") String sceneName);

    @Update("UPDATE scene SET sceneId = #{sceneId}, sceneNumber = #{sceneNumber} WHERE sceneName = #{sceneName}")
    Integer updateScene(Scene scene);

    @Select("SELECT * FROM scene WHERE customerId = #{customerId}")
    List<Scene> getSceneByCustomerId(@Param("customerId") Integer customerId);

    @Select("SELECT * FROM scene WHERE scene_id = #{scene_id}")
    Scene getSceneBySceneId(@Param("scene_id") Integer scene_id);

    @Delete("DELETE FROM scene WHERE scene_id = #{scene_id}")
    Integer deleteSceneBySceneId(@Param("scene_id") Integer scene_id);

}