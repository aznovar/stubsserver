package com.stubserver.model.service.ib;

public interface IbRemote<T> {


    /**
     * Метод, благодаря которому обрабатывается и формируется ответ из заглушки, с использованием сущности, не являющейся POJO
     * @param t
     * @return
     */
    T formingResponse(T t) throws Exception;
}
