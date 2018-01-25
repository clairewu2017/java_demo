/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.example.demo.mvc.repository;

import com.example.demo.mvc.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Allows managing {@link User} instances.
 *
 *
 */

//自动生成相应的GET POST 请求
@RepositoryRestResource(collectionResourceRel = "user", path="user")
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    //如果需要外部能通过url直接测试此方法，需要加上@Param("email")
    //http://localhost:8084/api/user/search/findByEmail?email=1@email.com
    User findByEmail(@Param("email") String email);
    List<User> findAllByUserNameEqualsAndEmailEquals(String userName, String email);
    List<User> findUsersByEmailContains(String email);
}
