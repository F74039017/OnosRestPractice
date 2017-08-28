/*
 * Copyright 2016-present Open Networking Laboratory
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.foo.l2sw;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.onosproject.rest.AbstractWebResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Title for swagger doc
 *
 */
@Path("/test")
public class TestRestResource extends AbstractWebResource {

    private LearningSwitchService learningSwitchService = get(LearningSwitchService.class);

    /**
     * Desc for the API.
	 *
	 * The period "." represent the end of the description
     *
     * REST API:
     * http://127.0.0.1:8181/onos/test/hello
     */
    @GET
    @Path("/hello")
    public Response hello() {
		ObjectNode root = mapper().createObjectNode();
		root.put("Hello", learningSwitchService.getHello())
				.put("TerryAlu", 1024);

		ArrayNode array = root.putArray("RadioStation");
		array.add("192.168.1.1").add("127.0.0.1")

        return ok(root).build();
    }

}
