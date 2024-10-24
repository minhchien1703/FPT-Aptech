package controller;

import dao.NationalDao;
import model.NationalModel;
import model.PlayerModel;

public class NationalController {
    NationalDao nationalDao = new NationalDao();

    public boolean createNewNational(NationalModel national) {
        return nationalDao.insertNewNational(national);
    }

    public boolean deleteNational(int id) {
        return nationalDao.deleteNationalById(id);
    }
}
