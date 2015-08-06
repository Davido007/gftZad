package com.gft.converters;

import com.gft.com.gft.dto.TransactionServiceDTO;
import com.gft.com.gft.dto.UserServiceDTO;
import com.gft.dto.UserDTO;
import com.gft.entities.UserEntity;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by dplichta on 2015-08-06.
 */
public class UserServiceConverter {
    public UserDTO convert(UserServiceDTO userServiceDTO) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userServiceDTO, userDTO);
        return userDTO;
    }

    public Collection<UserDTO> convertCollection(List<UserServiceDTO> userServiceDTOList) {
        Collection<UserDTO> userDTOs = new ArrayList<UserDTO>();
        userDTOs = CollectionUtils.collect(userServiceDTOList, new Transformer() {
            public UserDTO transform(Object each) {
                return convert((UserServiceDTO) each);
            }
        });
        return userDTOs;
    }
}
