/*
 * Copyright (C), 2011-2017.
 */
package io.chicken.ggs.service;

import io.chicken.ggs.dal.model.Depart;

import java.util.List;

/**
 *
 * @author wung 2017/8/27.
 */
public interface DepartService {

    List<Depart> queryByOrgancode(String organcode);

    Long save(Depart depart);

    void delete(Long id);
}
