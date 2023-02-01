package com.tsgl.service.impl;

import com.tsgl.dao.RecordDao;
import com.tsgl.dao.impl.RecordDaoImpl;
import com.tsgl.pojo.Record;
import com.tsgl.service.RecordService;

import java.util.List;


public class RecordServiceImpl implements RecordService {

    private RecordDao recordDao = new RecordDaoImpl();

    @Override
    public List<Record> selectRecords() {
        return recordDao.selectRecords();
    }

    @Override
    public List<Record> selectRecord(Integer userid) {
        return recordDao.selectRecord(userid);
    }

    @Override
    public boolean addRecord(Record record) {
        return recordDao.addRecord(record);
    }

    @Override
    public boolean deleteRecord(Integer borrowid) {
        return recordDao.deleteRecord(borrowid);
    }
}
