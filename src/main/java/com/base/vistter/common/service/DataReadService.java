package com.base.vistter.common.service;

import com.base.vistter.common.domain.ParamModel;
import com.base.vistter.common.domain.Result;
import com.base.vistter.common.domain.model.ReadModel;

public interface DataReadService {

    Result getResult(Result result, ReadModel model, ParamModel paramModel);

}
