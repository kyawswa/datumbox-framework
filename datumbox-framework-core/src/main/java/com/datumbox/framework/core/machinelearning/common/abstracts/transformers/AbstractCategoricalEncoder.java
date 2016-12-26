/**
 * Copyright (C) 2013-2016 Vasilis Vryniotis <bbriniotis@datumbox.com>
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
package com.datumbox.framework.core.machinelearning.common.abstracts.transformers;

import com.datumbox.framework.common.Configuration;
import com.datumbox.framework.common.dataobjects.TypeInference;
import com.datumbox.framework.core.machinelearning.common.abstracts.AbstractTrainer;

/**
 * Base class for all categorical encoders of the framework.
 *
 * @author Vasilis Vryniotis <bbriniotis@datumbox.com>
 * @param <MP>
 * @param <TP>
 */
public abstract class AbstractCategoricalEncoder<MP extends AbstractCategoricalEncoder.AbstractModelParameters, TP extends AbstractCategoricalEncoder.AbstractTrainingParameters> extends AbstractTransformer<MP, TP> {

    /**
     * @param trainingParameters
     * @param configuration
     * @see AbstractTrainer#AbstractTrainer(AbstractTrainer.AbstractTrainingParameters, Configuration)
     */
    protected AbstractCategoricalEncoder(TP trainingParameters, Configuration configuration) {
        super(trainingParameters, configuration);
    }

    /**
     * @param storageName
     * @param configuration
     * @see AbstractTrainer#AbstractTrainer(String, Configuration)
     */
    protected AbstractCategoricalEncoder(String storageName, Configuration configuration) {
        super(storageName, configuration);
    }

    /**
     * Checks whether the variable should be converted into dummy (boolean). Only
     * categorical and ordinal values are converted.
     *
     * @param columnType
     * @return
     */
    protected boolean covert2dummy(TypeInference.DataType columnType) {
        return columnType==TypeInference.DataType.CATEGORICAL || columnType==TypeInference.DataType.ORDINAL;
    }

}