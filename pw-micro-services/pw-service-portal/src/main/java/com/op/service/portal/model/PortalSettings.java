package com.op.service.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Pojo that contain the portal settings properties.
 * @author paolobonansea
 *
 */
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true, value = { "empty" })
@Data
public class PortalSettings {

    /**
     * Home page property portal setting.
     */
    @JsonProperty("home_page")
    private String homePage;

    /**
     * Emulators property portal setting.
     */
    private String emulator;

    /**
     * Default language property portal setting.
     */
    private String defaultLanguage;

    /**
     * Portal languages property portal settings.
     */
    private Set<String> languages = new LinkedHashSet<String>();

    /**
     * The portals relative path to root from the index.html file.
     */
    private String rootRelativePath;

    /**
     * The path to the index file of the portal.
     */
    private String indexFilePath;

    /**
     * Type portal (MULTILANGUAGE or SINGLE_LANGUAGE).
     */
    private PortalType type;

    /**
     * Css's property portal setting.
     */
    private List<Css> css;

    /**
     * Portal engine language settings.
     */
    private PortalEngineLangSettings languageSettings;

    /**
     * Whether push validation for the portal is enabled for both internal PUSH logic and via SSH.
     */
    private boolean gitValidation;

    /**
     * Portal engine dependencies, this
     * property will be ignored when read the info
     * from the portal-settings.json.
     */
    @JsonIgnore
    private Set<String> dependencies;

    /**
     * Portal engine external dependencies, this
     * property will be ignored when read the info
     * from the portal-settings.json.
     */
    @JsonIgnore
    private String externalDependencies;

    /**
     * Portal asset folder name.
     */
    private String assetFolder;

    /**
     * Pojo that contain info about the css files.
     * @author paolobonansea
     *
     */
    @Data
    public static class Css {

        /**
         * File css name.
         */
        private String name;

        /**
         * Href attribute vale.
         */
        private String href;

        /**
         * Folder path css file.
         */
        @JsonProperty("folder_path")
        private String folderPath;

        /**
         * Property to indicate if the file should be deleted or not.
         */
        private boolean isDeleted;

        /**
         * media type attribute value.
         */
        @JsonProperty("media_type")
        private String mediaType;

        /**
         * Version css file.
         */
        private String version;

    }

    /**
     * Enumeration to specify the portal type.
     * @author paolobonansea
     *
     */
    public enum PortalType {
        /**
         * Portal type multilanguage.
         */
        MULTILANGUAGE,

        /**
         * Portal type single language.
         */
        SINGLE_LANGUAGE,

        /**
         * Unknown Type.
         */
        UNKNOWN
    }

    /**
     * Portal engine language settings.
     * @author paolobonansea
     *
     */
    @Data
    public static class PortalEngineLangSettings {

        /**
         * Portal default language.
         */
        private String defaultLanguage;

        /**
         * Portal languages.
         */
        private Set<String> languages;

    }

}
