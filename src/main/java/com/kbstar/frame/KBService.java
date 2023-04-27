package com.kbstar.frame;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 등록 및 가입 진행
 * argument : Object
 * return : null
 *
 * @param adm
 *
 **/


public interface KBService <K,V>{
    @Transactional
    public void register(V v) throws Exception;

    @Transactional
    public void remove(K k) throws Exception;

    @Transactional
    public void modify(V v) throws Exception;

    @Transactional(readOnly = true)
    public V get(K k) throws Exception;

    @Transactional(readOnly = true)
    public List<V> get() throws Exception;
}
