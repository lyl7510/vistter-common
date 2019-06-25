package com.base.vistter.common.service;

import com.base.vistter.common.domain.ParamModel;
import com.base.vistter.common.domain.Result;
import com.base.vistter.common.domain.model.WriteModel;

public interface DataWriteService {

    Result getResult(Result result, WriteModel model, ParamModel paramModel);

}
