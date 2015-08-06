package com.gft.converters;

import com.gft.com.gft.dto.TransactionServiceDTO;
import com.gft.dto.TransactionDTO;
import com.gft.entities.TransactionEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dplichta on 2015-08-06.
 */
public class TransactionServiceConverter {
    public TransactionDTO convert(TransactionServiceDTO transactionServiceDTO) {
        TransactionDTO transactionDTO = new TransactionDTO();
        BeanUtils.copyProperties(transactionServiceDTO, transactionDTO);
        return transactionDTO;
    }

    public Collection<TransactionDTO> convertCollection(Collection<TransactionServiceDTO> accountServiceDTOList) {
        Collection<TransactionDTO> transactionDTOs = new ArrayList<TransactionDTO>();
        transactionDTOs = CollectionUtils.collect(accountServiceDTOList, new Transformer() {
            public TransactionDTO transform(Object each) {
                return convert((TransactionServiceDTO) each);
            }
        });
        return transactionDTOs;
    }
}
