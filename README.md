# editalbox
A simple tool for tracking your progress in civil service exams topics.  
  
// (pt-BR) Uma ferramenta simples para acompanhar seu progresso nas matérias de concursos públicos. //

### updates:
July27  
- Built project sketch  
- First commit to GitHub  

July28  
- Fixed GET method, now working  
- Moved Assessment files to a specific package  
- Added access modifiers that were missing in the  
  Controller and Service classes  
- Made changes to the Exam class  
- Removed the Subject class  
- Uncommented and made changes to the Content class  
- Related Exam and Content classes through @OneToMany  
  and @ManyToOne  
- Added POST method for exams table.  
- Separated the controllers, services and repositories,
  following the Single Responsibility Principle  
- Tested GET methods on Exam entity  
  [To-do: fix GET on Content entity and
  check if POST is also still working on both]  

July29  
- Fixed Content GET by adding @JsonIgnore. This avoids
  errors when using GET with entity of FetchType.LAZY  
- Added @PostLoad method to retrieve the foreign key
  in the Content GET when using FetchType.LAZY  
- Added POST method for columns table that links the
  Column entity to an Exam entity using its id  
  [To-do: add specific GETS, handle exceptions in requests]  
