package com.mtsmda.souvenir.repository;

import com.mtsmda.souvenir.model.Valute;

/**
 * Created by dminzat on 5/24/2016.
 */
public interface ValuteRepository {

    public boolean insertValute(Valute valute);
    public boolean updateValute(Valute valute);
    public boolean deleteValute(Valute valute);
    public boolean getValuteById(Integer valuteId);
    public boolean getValutes();
}