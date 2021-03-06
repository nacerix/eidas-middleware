/*
 * Copyright (c) 2020 Governikus KG. Licensed under the EUPL, Version 1.2 or as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work except
 * in compliance with the Licence. You may obtain a copy of the Licence at:
 * http://joinup.ec.europa.eu/software/page/eupl Unless required by applicable law or agreed to in writing,
 * software distributed under the Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package de.governikus.eumw.configuration.wizard.web.controller.validators;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;

import de.governikus.eumw.configuration.wizard.web.model.ConfigurationForm;
import lombok.extern.slf4j.Slf4j;


/**
 * author Pascal Knueppel <br>
 * created at: 04.04.2018 - 12:13 <br>
 * <br>
 * this validator will check the base path that it does exist and that the given directory has write access to
 * it
 */
@Slf4j
public class BasePathValidator extends ViewValidator
{

  /**
   * {@inheritDoc}
   */
  @Override
  public void validateView(ConfigurationForm configurationForm, BindingResult bindingResult)
  {
    final String configDirectoryId = "configDirectory.configDirectory";
    if (configurationForm.getConfigDirectory() == null
        || StringUtils.isBlank(configurationForm.getConfigDirectory().getConfigDirectory()))
    {
      return;
    }
    File file = new File(StringUtils.stripToEmpty(configurationForm.getConfigDirectory()
                                                                   .getConfigDirectory()));
    if (!file.isDirectory())
    {
      bindingResult.rejectValue(configDirectoryId,
                                null,
                                "path is not a directory '" + file.getAbsolutePath() + "'");
    }
  }
}
