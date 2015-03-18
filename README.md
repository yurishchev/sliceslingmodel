Slice versus Sling Models - Comparison
===========================

Slice – https://cognifide.atlassian.net/wiki/display/SLICE, current version is 4.1 (AEM6.*-compliant) 
Sling Models - http://sling.apache.org/documentation/bundles/models.html, current version is 1.0.4, out-of-the-box bundle from AEM, tightly coupled to AEM release.


Comparison Table.
===========================

Feature                                         Slice           Sling Models

Map JCR Primitives                               Yes                Yes
Map JCR Multi Properties                         Yes                Yes
Map Enumerated Type (from String property)       Yes                No
Map Direct Child Model                           Yes                Yes
Map Collection of Child Models                   Yes                No, will be in 1.2.0?
Map Referenced (via path) Model                  Yes                No
Map Current Resource                             Yes                Yes
Map Current Page                                 Yes                No, will be in 1.2.0?
Map SlingHttpServletRequest                      Yes                No, will be in 1.2.0?
Map ResourceResolver                             Yes                No, will be in 1.2.0?
Post Construct Method                            Yes                Yes
OSGI Standard (OOB) Service                      Yes                Yes
OSGI Custom Service                              Yes                Yes
Map Child Model via its interface                No                 No
Map Inheritable Property                         Yes (custom code)  Yes (custom pretty ugly code required due to lack of custom annotations)
Custom Annotations                               Yes, via Guice     No, will be in 1.0.6
Programmatic injection (using framework API)     Yes                No, will be in 1.2.0?
@Via and @Source annotations                     No                 Yes 
@Escape annotation                               Yes                No
	
Deployment complexity                            4 bundles          None
AEM compliance                                   3rd party bundle.  Native bundle. Tightly coupled with certain AEM release (1.0.4 for AEM60 SP1)
Ease of Use                                      Yes                Yes
Framework Extensibility                          Easy/Medium        Easy/Medium


Slice and Sling Models CAN be used in one AEM application if correctly split into different bundles.
 


Conclusion.
========================

Current AEM version (6.0 with SP1) contains Sling Models v1.0.4 which lacks many useful features and loses the battle with Slice. 
Some of these features can be obtained by adding third-party bundles and writing custom code, but it’s yet another layer of complexity. 
Since version 1.2.0  Sling Models will become a good alternative for Slice and potentially can even beat it because it is a native 
Sling framework which comes OOB and is being very actively developed.  Nowadays it is still on the early stages of maturity.


I consider Slice to be a preferred framework with prevailing proven features. 
I also recommend returning to this comparison once AEM includes Sling Models 1.2.*

