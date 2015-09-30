package com.op.service.portal.model.to;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.op.service.portal.model.Portal;
import com.op.service.portal.model.PortalSettings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * OpenPortal Struct.
 * @author jlangley
 *
 */
@Data
@JsonInclude(Include.NON_DEFAULT)
@RequiredArgsConstructor
@AllArgsConstructor
public class OpenPortalStruct {
    private Portal portal;
    private PortalSettings portalSettings;
    private String userGitUrl;
}
