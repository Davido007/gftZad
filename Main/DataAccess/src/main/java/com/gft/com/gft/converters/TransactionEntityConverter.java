package com.gft.com.gft.converters;

import com.gft.com.gft.dto.TransactionServiceDTO;
import com.gft.entities.TransactionEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by dplichta on 2015-08-06.
 */
public class TransactionEntityConverter {
    public TransactionServiceDTO convert (TransactionEntity transactionEntity){
        TransactionServiceDTO transactionServiceDTO = new TransactionServiceDTO();
        BeanUtils.copyProperties(transactionEntity, transactionServiceDTO);
        return transactionServiceDTO;
    }
}
