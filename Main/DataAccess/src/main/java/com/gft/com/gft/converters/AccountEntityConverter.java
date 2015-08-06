package com.gft.com.gft.converters;

import com.gft.com.gft.dto.AccountServiceDTO;
import com.gft.entities.AccountEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by dplichta on 2015-08-06.
 */
public class AccountEntityConverter {
    public AccountServiceDTO convert (AccountEntity accountEntity){
        AccountServiceDTO accountServiceDTO = new AccountServiceDTO();
        BeanUtils.copyProperties(accountEntity, accountServiceDTO);
        return accountServiceDTO;
    }
}
