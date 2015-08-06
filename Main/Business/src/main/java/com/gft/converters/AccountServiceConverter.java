package com.gft.converters;

import com.gft.com.gft.dto.AccountServiceDTO;
import com.gft.dto.AccountDTO;
import com.gft.entities.AccountEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dplichta on 2015-08-06.
 */
public class AccountServiceConverter {
    public AccountDTO convert (AccountServiceDTO accountServiceDTO){
        AccountDTO accountDTO = new AccountDTO();
        BeanUtils.copyProperties(accountServiceDTO, accountDTO);
        return accountDTO;
    }
    public Collection<AccountDTO> convertCollection (List<AccountServiceDTO> accountServiceDTOList){
        Collection<AccountDTO> accountDTOs = new ArrayList<AccountDTO>();
        accountDTOs = CollectionUtils.collect(accountServiceDTOList, new Transformer() {
            public AccountDTO transform(Object each) {
                return convert((AccountServiceDTO)each);
            }
        });
        return accountDTOs;
    }
}
