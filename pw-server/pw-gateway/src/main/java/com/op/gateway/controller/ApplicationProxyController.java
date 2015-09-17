package com.op.gateway.controller;


//@RestController
//@RequestMapping("/app")
//public class ApplicationProxyController {
//    @Autowired
//    private Environment environment;
//
//    /**
//     * Resource method that returns the portal asset.
//     * @return Response
//     * @throws IOException IOException
//     */
//    @RequestMapping(value="/**", method = RequestMethod.GET)
//    public ResponseEntity getAsset(final HttpServletRequest request) throws IOException {
//        String path = (String) request.getAttribute(
//                HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
//        String bestMatchPattern = (String ) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
//
//        AntPathMatcher apm = new AntPathMatcher();
//        String finalPath = apm.extractPathWithinPattern(bestMatchPattern, path);
//
//        URL url = new URL(environment.getProperty("bsd.frontEndAppUrl") + "/" + finalPath);
//
//        try (InputStream is = url.openStream()) {
//            return ResponseEntity.ok().body(IOUtils.toByteArray(is));
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
//        }
//    }
//}
