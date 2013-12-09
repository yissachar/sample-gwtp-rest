package com.fave100.samples.gwtprest.shared;

import java.util.List;

import com.gwtplatform.dispatch.shared.Result;

@SuppressWarnings("serial")
public class FaveItemCollection implements Result {
	List<FaveItem> items;

    protected FaveItemCollection() {
    }

    public FaveItemCollection(List<FaveItem> items) {
        this.items = items;
    }

    public List<FaveItem> getItems() {
        return items;
    }
}

