package com.gft.com.gft.converters;

import com.gft.com.gft.dto.UserServiceDTO;
import com.gft.entities.UserEntity;
import org.springframework.beans.BeanUtils;

/**
 * Created by dplichta on 2015-08-06.
 */
public class UserEntityConverter {
    public UserServiceDTO convert (UserEntity userEntity){
        UserServiceDTO userServiceDTO = new UserServiceDTO();
        BeanUtils.copyProperties(userEntity, userServiceDTO);
        return userServiceDTO;
    }
}
