/*==============================================================*/
/* DBMS name:      Microsoft SQL Server 2012                    */
/* Created on:     2017/12/17/周日 10:44:21                       */
/*==============================================================*/
use master
 --drop database YunXue
go
create database YunXue
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('bindingTeacher') and o.name = 'FK_BINDINGT_REFERENCE_CLASSPLA')
alter table bindingTeacher
   drop constraint FK_BINDINGT_REFERENCE_CLASSPLA
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('bindingTeacher') and o.name = 'FK_BINDINGT_REFERENCE_STUDENTT')
alter table bindingTeacher
   drop constraint FK_BINDINGT_REFERENCE_STUDENTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('buyclass') and o.name = 'FK_BUYCLASS_REFERENCE_STUDENTT')
alter table buyclass
   drop constraint FK_BUYCLASS_REFERENCE_STUDENTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('class') and o.name = 'FK_CLASS_REFERENCE_TEACHERT')
alter table class
   drop constraint FK_CLASS_REFERENCE_TEACHERT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('class') and o.name = 'FK_CLASS_REFERENCE_STUDENTT')
alter table class
   drop constraint FK_CLASS_REFERENCE_STUDENTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('classPlan') and o.name = 'FK_CLASSPLA_REFERENCE_TEACHERT')
alter table classPlan
   drop constraint FK_CLASSPLA_REFERENCE_TEACHERT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('listenK') and o.name = 'FK_LISTENK_REFERENCE_TEACHERT')
alter table listenK
   drop constraint FK_LISTENK_REFERENCE_TEACHERT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('listenK') and o.name = 'FK_LISTENK_REFERENCE_STUDENTT')
alter table listenK
   drop constraint FK_LISTENK_REFERENCE_STUDENTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('operateRecord') and o.name = 'FK_OPERATER_REFERENCE_CLASS')
alter table operateRecord
   drop constraint FK_OPERATER_REFERENCE_CLASS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('operateRecord') and o.name = 'FK_OPERATER_REFERENCE_STUDENTT')
alter table operateRecord
   drop constraint FK_OPERATER_REFERENCE_STUDENTT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('tIdentify') and o.name = 'FK_TIDENTIF_REFERENCE_TEACHERT')
alter table tIdentify
   drop constraint FK_TIDENTIF_REFERENCE_TEACHERT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('bindingTeacher')
            and   type = 'U')
   drop table bindingTeacher
go

if exists (select 1
            from  sysobjects
           where  id = object_id('buyclass')
            and   type = 'U')
   drop table buyclass
go

if exists (select 1
            from  sysobjects
           where  id = object_id('class')
            and   type = 'U')
   drop table class
go

if exists (select 1
            from  sysobjects
           where  id = object_id('classInterval')
            and   type = 'U')
   drop table classInterval
go

if exists (select 1
            from  sysobjects
           where  id = object_id('classPlan')
            and   type = 'U')
   drop table classPlan
go

if exists (select 1
            from  sysobjects
           where  id = object_id('listenK')
            and   type = 'U')
   drop table listenK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('operateRecord')
            and   type = 'U')
   drop table operateRecord
go

if exists (select 1
            from  sysobjects
           where  id = object_id('servicer')
            and   type = 'U')
   drop table servicer
go

if exists (select 1
            from  sysobjects
           where  id = object_id('studentT')
            and   type = 'U')
   drop table studentT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('tIdentify')
            and   type = 'U')
   drop table tIdentify
go

if exists (select 1
            from  sysobjects
           where  id = object_id('teacherT')
            and   type = 'U')
   drop table teacherT
go

/*==============================================================*/
/* Table: bindingTeacher                                        */
/*==============================================================*/
create table bindingTeacher (
   bindNo               int                  identity(1001,1),
   stuNo                int                  null,
   planClassNo          int                  null,
   bindMoney            int                  null,
   constraint PK_BINDINGTEACHER primary key (bindNo)
)
go

/*==============================================================*/
/* Table: buyclass                                              */
/*==============================================================*/
create table buyclass (
   buyNo                int                  identity(1001,1),
   stuNo                int                  null,
   buyAmount            int                  null,
   buyMoney             int                  null,
   buyState             char(10)             null,
   buyStuStage          varchar(20)          null,
   buyStuGrade          varchar(30)          null,
   constraint PK_BUYCLASS primary key (buyNo)
)
go

/*==============================================================*/
/* Table: class                                                 */
/*==============================================================*/
create table class (
   classNo              int                  identity(1001,1),
   teacherNo            int                  null,
   stuNo                int                  null,
   classDate            varchar(20)          null,
   classTime            varchar(20)          null,
   classState           char(1)              null,
   classComt            varchar(300)         null,
   classLevel           varchar(5)           null,
   className            varchar(20)          null,
   classMoney           int                  null,
   classReview          varchar(500)         null,
   courseState2         char(1)              null,
   constraint PK_CLASS primary key (classNo)
)
go

/*==============================================================*/
/* Table: classInterval                                         */
/*==============================================================*/
create table classInterval (
   intervalNo           int                  identity(101,1),
   intervalDate         varchar(10)          null,
   intervalTime         varchar(20)          null,
   constraint PK_CLASSINTERVAL primary key (intervalNo)
)
go

/*==============================================================*/
/* Table: classPlan                                             */
/*==============================================================*/
create table classPlan (
   planClassNo          int                  identity(1001,1),
   teacherNo            int                  null,
   planClassDate        varchar(10)          null,
   planClassTime        varchar(20)          null,
   planClassName        varchar(50)          null,
   planClassState       char(1)              null,
   constraint PK_CLASSPLAN primary key (planClassNo)
)
go

/*==============================================================*/
/* Table: listenK                                               */
/*==============================================================*/
create table listenK (
   listenNo             int                  identity(1001,1),
   teacherNo            int                  null,
   stuNo                int                  null,
   listenTime           varchar(20)          null,
   listenStage          varchar(30)          null,
   listenClass          varchar(30)          null,
   constraint PK_LISTENK primary key (listenNo)
)
go

/*==============================================================*/
/* Table: operateRecord                                         */
/*==============================================================*/
create table operateRecord (
   recordId             int                  identity(1001,1),
   classNo              int                  null,
   stuNo                int                  null,
   recordTime           varchar(20)          null,
   recordOperate        varchar(10)          null,
   constraint PK_OPERATERECORD primary key (recordId)
)
go

/*==============================================================*/
/* Table: servicer                                              */
/*==============================================================*/
create table servicer (
   serNo                int                  identity(101,1),
   serLimit             varchar(10)          null,
   serUser              varchar(20)          null,
   serPwd               varchar(20)          null,
   constraint PK_SERVICER primary key (serNo)
)
go

/*==============================================================*/
/* Table: studentT                                              */
/*==============================================================*/
create table studentT (
   stuNo                int                  identity(1001,1),
   stuPhone             char(11)             null,
   stuPwd               varchar(20)          null,
   stuName              varchar(10)          null,
   stuMoney             int                  null,
   stuState             char(1)              null,
   stuImg               varchar(100)          null,
   stuBirth             varchar(30)          null,
   stuSex               char(4)              null,
   stuStage             varchar(5)           null,
   stuSchool            varchar(50)          null,
   constraint PK_STUDENTT primary key (stuNo)
)
go

/*==============================================================*/
/* Table: tIdentify                                             */
/*==============================================================*/
create table tIdentify (
   tIdentityNo          int                  identity(1001,1),
   teacherNo            int                  null,
   tName                varchar(10)          null,
   tAge                 int                  null,
   tArea                varchar(40)          null,
   tSchool              varchar(40)          null,
   tIdcard              varchar(20)          null,
   tIdcardImg           varchar(100)          null,
   tStudentcardImg      varchar(100)          null,
   tPicture             varchar(100)          null,
   tExperience          varchar(500)         null,
   tSex                 char(4)              null,
   tDescription         varchar(600)         null,
   tMajor               varchar(50)          null,
   tEducation           varchar(30)          null,
   constraint PK_TIDENTIFY primary key (tIdentityNo)
)
go

/*==============================================================*/
/* Table: teacherT                                              */
/*==============================================================*/
create table teacherT (
   teacherNo            int                  identity(1001,1),
   teacherPhone         varchar(15)          null,
   teacherPwd           varchar(20)          null,
   teacherName          varchar(10)          null,
   teacherSatisfaction  varchar(6)           null,
   teacherStyle         varchar(100)         null,
   teacherMoney         int                  null,
   teacherClasses       varchar(100)         null,
   teacherStage         varchar(20)          null,
   teacherState         char(1)              null,
   constraint PK_TEACHERT primary key (teacherNo)
)
go

alter table bindingTeacher
   add constraint FK_BINDINGT_REFERENCE_CLASSPLA foreign key (planClassNo)
      references classPlan (planClassNo)
go

alter table bindingTeacher
   add constraint FK_BINDINGT_REFERENCE_STUDENTT foreign key (stuNo)
      references studentT (stuNo)
go

alter table buyclass
   add constraint FK_BUYCLASS_REFERENCE_STUDENTT foreign key (stuNo)
      references studentT (stuNo)
go

alter table class
   add constraint FK_CLASS_REFERENCE_TEACHERT foreign key (teacherNo)
      references teacherT (teacherNo)
go

alter table class
   add constraint FK_CLASS_REFERENCE_STUDENTT foreign key (stuNo)
      references studentT (stuNo)
go

alter table classPlan
   add constraint FK_CLASSPLA_REFERENCE_TEACHERT foreign key (teacherNo)
      references teacherT (teacherNo)
go

alter table listenK
   add constraint FK_LISTENK_REFERENCE_TEACHERT foreign key (teacherNo)
      references teacherT (teacherNo)
go

alter table listenK
   add constraint FK_LISTENK_REFERENCE_STUDENTT foreign key (stuNo)
      references studentT (stuNo)
go

alter table operateRecord
   add constraint FK_OPERATER_REFERENCE_CLASS foreign key (classNo)
      references class (classNo)
go

alter table operateRecord
   add constraint FK_OPERATER_REFERENCE_STUDENTT foreign key (stuNo)
      references studentT (stuNo)
go

alter table tIdentify
   add constraint FK_TIDENTIF_REFERENCE_TEACHERT foreign key (teacherNo)
      references teacherT (teacherNo)
go





/* 教师主要信息视图 */
go
create view teacher_info(teacherNo,tPicture,tName,tSex,tAge,tSchool,teacherSatisfaction,teacherStyle,teacherStage,teacherClasses,tDescription,tMajor,tEducation,tExperience)
as
select teacherT.teacherNo,tIdentify.tPicture,tIdentify.tName,tIdentify.tSex,tIdentify.tAge,tIdentify.tSchool,teacherT.teacherSatisfaction,teacherT.teacherStyle,teacherT.teacherStage,teacherT.teacherClasses,tIdentify.tDescription,tIdentify.tMajor,tIdentify.tEducation,tIdentify.tExperience
from tIdentify,teacherT
where tIdentify.teacherNo=teacherT.teacherNo
go

--select * from teacher_info


/* 试听课信息视图 */
go
create view listenClass(listenNo,listenTime,listenStage,listenClass,teacherName,stuPhone)
as
select listenK.listenNo,listenTime,listenk.listenStage,listenK.listenClass,teacherT.teacherName,studentT.stuPhone
from listenK,teacherT,studentT
where listenk.stuNo=studentT.stuNo and listenk.teacherNo=teacherT.teacherNo
go

--select * from listenClass


/* 教师课表视图 */
go
create view teacher_schedule(teacherNo,teacherName,planClassDate,planClassTime,planClassName,planClassState)
as
select teacherT.teacherNo,teacherT.teacherName,classPlan.planClassDate,classPlan.planClassTime,classPlan.planClassName,classPlan.planClassState
from teacherT,classPlan
where teacherT.teacherNo=classPlan.teacherNo
go

--select * from teacher_schedule


/* 课程信息视图 */
go
create view class_info(classNo,teacherName,tPicture,className,classDate,classTime,classLevel,classMoney,classComt,classState)
as
select class.classNo,teacherT.teacherName,tIdentify.tPicture,class.className,class.classDate,class.classTime,class.classLevel,class.classMoney,class.classComt,class.classState
from teacherT,tIdentify,class
where teacherT.teacherNo=tIdentify.teacherNo and teacherT.teacherNo=class.teacherNo
go

--select * from class_info



/* 上课履历视图 */
go
create view class_resume(classNo,stuNo,className,teacherName,tPicture,classDate,classTime,classState,classComt,classLevel,classReview,courseState2)
as
select class.classNo,class.stuNo,class.className,teacherT.teacherName,tIdentify.tPicture,class.classDate,class.classTime,class.classState,class.classComt,class.classLevel,class.classReview,class.courseState2
from studentT,teacherT,class,tIdentify
where studentT.stuNo=class.stuNo and class.teacherNo=teacherT.teacherNo and teacherT.teacherNo=tIdentify.teacherNo
go

--select * from class_resume


/* 操作明细视图 */
go
create view record(recordId,stuName,className,teacherName,classDate,classTime,recordTime,recordOperate,classMoney)
as
select operateRecord.recordId,studentT.stuName,class.className,teacherT.teacherName,class.classDate,class.classTime,operateRecord.recordTime,operateRecord.recordOperate,class.classMoney
from studentT,teacherT,class,operateRecord
where studentT.stuNo=class.stuNo and class.teacherNo=teacherT.teacherNo and operateRecord.classNo=class.classNo and operateRecord.stuNo=studentT.stuNo
go

--select * from record


/* 绑定教师信息视图 */
go
create view binding_info(bindNo,stuName,planClassName,teacherName,planClassDate,planClassTime,bindMoney,planClassState)
as
select bindingTeacher.bindNo,studentT.stuName,classPlan.planClassName,teacherT.teacherName,classPlan.planClassDate,classPlan.planClassTime,bindingTeacher.bindMoney,classPlan.planClassState
from studentT,teacherT,classPlan,bindingTeacher
where bindingTeacher.stuNo=studentT.stuNo and bindingTeacher.planClassNo=classPlan.planClassNo and classPlan.teacherNo=teacherT.teacherNo
go

--select * from binding_info


/* 购买课时信息视图 */
go
create view buy_info(buyNo,stuName,buyAmount,buyMoney,buyState)
as
select buyclass.buyNo,studentT.stuName,buyclass.buyAmount,buyclass.buyMoney,buyclass.buyState
from studentT,buyclass
where studentT.stuNo=buyclass.stuNo
go

--select * from buy_info