package com.stubserver.model.service.bso;

import com.stubserver.model.entities.bso.requestentities.FullBSOEntity;

public interface BsoRemote<T> {

    /**
     * Метод, благодаря которому обрабатывается и формируется ответ из заглушки, с использованием POJO
     * @param fullBSOEntity
     * @return
     */
    T formingResponse(FullBSOEntity fullBSOEntity);
}
