/*
 * Copyright (c) 2020 Governikus KG. Licensed under the EUPL, Version 1.2 or as soon they will be approved by
 * the European Commission - subsequent versions of the EUPL (the "Licence"); You may not use this work except
 * in compliance with the Licence. You may obtain a copy of the Licence at:
 * http://joinup.ec.europa.eu/software/page/eupl Unless required by applicable law or agreed to in writing,
 * software distributed under the Licence is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

package de.governikus.eumw.configuration.wizard.web.utils;

import org.apache.logging.log4j.core.util.Throwables;


/**
 * author Pascal Knueppel <br>
 * created at: 29.03.2018 - 14:08 <br>
 * <br>
 */
public final class ExceptionHelper
{

  /**
   * utility class constructor
   */
  private ExceptionHelper()
  {
    super();
  }

  /**
   * will get the root error message
   *
   * @param throwable the current exception that might not have the correct error message
   * @return the root message of the exception
   */
  public static String getRootMessage(Throwable throwable)
  {
    Throwable root = Throwables.getRootCause(throwable);
    return root == null ? throwable.getMessage() : root.getMessage();
  }
}
