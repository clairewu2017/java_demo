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

import com.example.demo.mvc.model.Permission;
import com.example.demo.mvc.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Allows managing {@link User} instances.
 *
 *
 */

//自动生成相应的GET POST 请求
@RepositoryRestResource(collectionResourceRel = "permission", path="permission")
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long> {

    @Query(value = "select p.name from permission p join role_permission rp on p.id = rp.permission_id\n" +
            " join user_role ur on rp.role_id = ur.role_id" +
            " where ur.user_id  = ?1", nativeQuery = true)
    List<String> findByUser(long userId);

}




