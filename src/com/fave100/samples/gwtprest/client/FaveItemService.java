package com.fave100.samples.gwtprest.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.fave100.samples.gwtprest.shared.FaveItemCollection;
import com.gwtplatform.dispatch.shared.Action;
import com.gwtplatform.dispatch.shared.rest.RestService;

@Path("/messageapi/v1")
public interface FaveItemService extends RestService {

	@GET
	@Path("/faveitem")
	public Action<FaveItemCollection> listFaveItems();
}
