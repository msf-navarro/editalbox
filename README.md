# editalbox

<br/>
A simple tool for tracking your progress in civil service exams topics.  
  
// (pt-BR) Uma ferramenta simples para acompanhar seu progresso nas matérias de concursos públicos. //
<br/>

### updates:

August04<br/>
- Added new packages to separate files, following
  conventions in project structure.<br/>
- Separated the Config class into individual classes for
  each entity.<br/>
- Fixed a bug where the ContentConfig would initialize
  instances of Content without linking examId to exam.<br/>
- Rewrote services as interfaces to support
  implementations and dependency injection.<br/>
  [To-do: add automated tests (QoL), handle bad input in requests, Spring Security]<br/>

August01<br/>
- Added GET(individual), PUT and DELETE methods to the
  Exam entity.<br/>
- Renamed some methods' url paths to mark them for later
  Spring Security implementations.<br/>
- Added a specific GET method to request all Contents
  related to a specific Exam. (gelAllContentsFromExamId)<br/>
- Added PUT and DELETE methods to the Content entity.<br/>
- Handled null exceptions in PUT requests.<br/>
- Tested internal interactions in Content PUT, e.g.
  changes in parameter exam using PUT are reflected in
  the parameters examId and examName showed in the GET.<br/>
- Tested interaction between Exam and Content requests,
  e.g. Exam PUT changes are present in Content GET.<br/>
  [To-do: handle bad input in requests, Spring Security]<br/>

July29<br/>
- Fixed Content GET by adding @JsonIgnore. This avoids
  errors when using GET with entity of FetchType.LAZY.<br/>
- Added @PostLoad method to retrieve the foreign key
  in the Content GET when using FetchType.LAZY.<br/>
- Added POST method for columns table that links the
  Column entity to an Exam entity using its id.<br/>
  [To-do: add specific GETS, handle exceptions in requests]<br/>

July28<br/>
- Fixed GET method, now working.<br/>
- Moved Assessment files to a specific package.<br/>
- Added access modifiers that were missing in the 
Controller and Service classes.<br/>
- Made changes to the Exam class.<br/>
- Removed the Subject class.<br/>
- Uncommented and made changes to the Content class.<br/>
- Related Exam and Content classes through @OneToMany  
  and @ManyToOne.<br/>
- Added POST method for exams table.<br/>
- Separated the controllers, services and repositories,
  following the Single Responsibility Principle.<br/>
- Tested GET methods on Exam entity.<br/>  
  [To-do: fix GET on Content entity and
  check if POST is also still working on both]<br/>

July27  
- Built project sketch.<br/>
- First commit to GitHub.<br/>