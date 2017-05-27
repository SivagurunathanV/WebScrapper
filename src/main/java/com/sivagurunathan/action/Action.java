package com.sivagurunathan.action;

import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by sivagurunathan.v on 20/05/17.
 */
public interface Action<T> {

    public T invoke();

}
