USE [master]
GO

/****** Object:  Database [ApptsDB]    Script Date: 14/09/2015 14:46:55 ******/
DROP DATABASE [ApptsDB]
GO

/****** Object:  Database [ApptsDB]    Script Date: 14/09/2015 14:46:55 ******/
CREATE DATABASE [ApptsDB]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ApptsDB', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ApptsDB.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ApptsDB_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ApptsDB_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO

ALTER DATABASE [ApptsDB] SET COMPATIBILITY_LEVEL = 120
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ApptsDB].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [ApptsDB] SET ANSI_NULL_DEFAULT OFF 
GO

ALTER DATABASE [ApptsDB] SET ANSI_NULLS OFF 
GO

ALTER DATABASE [ApptsDB] SET ANSI_PADDING OFF 
GO

ALTER DATABASE [ApptsDB] SET ANSI_WARNINGS OFF 
GO

ALTER DATABASE [ApptsDB] SET ARITHABORT OFF 
GO

ALTER DATABASE [ApptsDB] SET AUTO_CLOSE ON 
GO

ALTER DATABASE [ApptsDB] SET AUTO_SHRINK OFF 
GO

ALTER DATABASE [ApptsDB] SET AUTO_UPDATE_STATISTICS ON 
GO

ALTER DATABASE [ApptsDB] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO

ALTER DATABASE [ApptsDB] SET CURSOR_DEFAULT  GLOBAL 
GO

ALTER DATABASE [ApptsDB] SET CONCAT_NULL_YIELDS_NULL OFF 
GO

ALTER DATABASE [ApptsDB] SET NUMERIC_ROUNDABORT OFF 
GO

ALTER DATABASE [ApptsDB] SET QUOTED_IDENTIFIER OFF 
GO

ALTER DATABASE [ApptsDB] SET RECURSIVE_TRIGGERS OFF 
GO

ALTER DATABASE [ApptsDB] SET  ENABLE_BROKER 
GO

ALTER DATABASE [ApptsDB] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO

ALTER DATABASE [ApptsDB] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO

ALTER DATABASE [ApptsDB] SET TRUSTWORTHY OFF 
GO

ALTER DATABASE [ApptsDB] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO

ALTER DATABASE [ApptsDB] SET PARAMETERIZATION SIMPLE 
GO

ALTER DATABASE [ApptsDB] SET READ_COMMITTED_SNAPSHOT ON 
GO

ALTER DATABASE [ApptsDB] SET HONOR_BROKER_PRIORITY OFF 
GO

ALTER DATABASE [ApptsDB] SET RECOVERY SIMPLE 
GO

ALTER DATABASE [ApptsDB] SET  MULTI_USER 
GO

ALTER DATABASE [ApptsDB] SET PAGE_VERIFY CHECKSUM  
GO

ALTER DATABASE [ApptsDB] SET DB_CHAINING OFF 
GO

ALTER DATABASE [ApptsDB] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO

ALTER DATABASE [ApptsDB] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO

ALTER DATABASE [ApptsDB] SET DELAYED_DURABILITY = DISABLED 
GO

ALTER DATABASE [ApptsDB] SET  READ_WRITE 
GO

USE [ApptsDB]
GO

ALTER TABLE [dbo].[Prescriptions] DROP CONSTRAINT [FK_dbo.Prescriptions_dbo.Patients_Patient_ID]
GO

ALTER TABLE [dbo].[Prescriptions] DROP CONSTRAINT [FK_dbo.Prescriptions_dbo.Medications_Medication_ID]
GO

ALTER TABLE [dbo].[Prescriptions] DROP CONSTRAINT [FK_dbo.Prescriptions_dbo.Doctors_Doctor_ID]
GO

ALTER TABLE [dbo].[Prescriptions] DROP CONSTRAINT [FK_dbo.Prescriptions_dbo.Appointments_Appointment_ID]
GO

ALTER TABLE [dbo].[PatientsDoctors] DROP CONSTRAINT [FK_PatientsDoctors_Patients]
GO

ALTER TABLE [dbo].[PatientsDoctors] DROP CONSTRAINT [FK_PatientsDoctors_Doctors]
GO

ALTER TABLE [dbo].[Patients] DROP CONSTRAINT [FK_Patients_AspNetUsers]
GO

ALTER TABLE [dbo].[Doctors] DROP CONSTRAINT [FK_Doctors_AspNetUsers]
GO

ALTER TABLE [dbo].[AspNetUserRoles] DROP CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[AspNetUserRoles] DROP CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetRoles_RoleId]
GO

ALTER TABLE [dbo].[AspNetUserLogins] DROP CONSTRAINT [FK_dbo.AspNetUserLogins_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[AspNetUserClaims] DROP CONSTRAINT [FK_dbo.AspNetUserClaims_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[Appointments] DROP CONSTRAINT [FK_dbo.Appointments_dbo.Patients_Patient_ID]
GO

ALTER TABLE [dbo].[Appointments] DROP CONSTRAINT [FK_dbo.Appointments_dbo.Doctors_Doctor_ID]
GO

/****** Object:  Table [dbo].[Prescriptions]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[Prescriptions]
GO

/****** Object:  Table [dbo].[PatientsDoctors]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[PatientsDoctors]
GO

/****** Object:  Table [dbo].[Patients]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[Patients]
GO

/****** Object:  Table [dbo].[Medications]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[Medications]
GO

/****** Object:  Table [dbo].[Doctors]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[Doctors]
GO

/****** Object:  Table [dbo].[AspNetUsers]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[AspNetUsers]
GO

/****** Object:  Table [dbo].[AspNetUserRoles]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[AspNetUserRoles]
GO

/****** Object:  Table [dbo].[AspNetUserLogins]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[AspNetUserLogins]
GO

/****** Object:  Table [dbo].[AspNetUserClaims]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[AspNetUserClaims]
GO

/****** Object:  Table [dbo].[AspNetRoles]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[AspNetRoles]
GO

/****** Object:  Table [dbo].[Appointments]    Script Date: 14/09/2015 14:46:15 ******/
DROP TABLE [dbo].[Appointments]
GO

/****** Object:  Table [dbo].[Appointments]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Appointments](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](max) NOT NULL,
	[Diagnosis] [nvarchar](max) NULL,
	[StartDateTime] [datetime] NOT NULL,
	[EndDateTime] [datetime] NOT NULL,
	[Doctor_ID] [int] NOT NULL,
	[Patient_ID] [int] NOT NULL,
 CONSTRAINT [PK_dbo.Appointments] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[AspNetRoles]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AspNetRoles](
	[Id] [nvarchar](128) NOT NULL,
	[Name] [nvarchar](256) NOT NULL,
 CONSTRAINT [PK_dbo.AspNetRoles] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[AspNetUserClaims]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AspNetUserClaims](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [nvarchar](128) NOT NULL,
	[ClaimType] [nvarchar](max) NULL,
	[ClaimValue] [nvarchar](max) NULL,
 CONSTRAINT [PK_dbo.AspNetUserClaims] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[AspNetUserLogins]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AspNetUserLogins](
	[LoginProvider] [nvarchar](128) NOT NULL,
	[ProviderKey] [nvarchar](128) NOT NULL,
	[UserId] [nvarchar](128) NOT NULL,
 CONSTRAINT [PK_dbo.AspNetUserLogins] PRIMARY KEY CLUSTERED 
(
	[LoginProvider] ASC,
	[ProviderKey] ASC,
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[AspNetUserRoles]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AspNetUserRoles](
	[UserId] [nvarchar](128) NOT NULL,
	[RoleId] [nvarchar](128) NOT NULL,
 CONSTRAINT [PK_dbo.AspNetUserRoles] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC,
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[AspNetUsers]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[AspNetUsers](
	[Id] [nvarchar](128) NOT NULL,
	[Email] [nvarchar](256) NULL,
	[EmailConfirmed] [bit] NOT NULL,
	[PasswordHash] [nvarchar](max) NULL,
	[SecurityStamp] [nvarchar](max) NULL,
	[PhoneNumber] [nvarchar](max) NULL,
	[PhoneNumberConfirmed] [bit] NOT NULL,
	[TwoFactorEnabled] [bit] NOT NULL,
	[LockoutEndDateUtc] [datetime] NULL,
	[LockoutEnabled] [bit] NOT NULL,
	[AccessFailedCount] [int] NOT NULL,
	[UserName] [nvarchar](256) NOT NULL,
 CONSTRAINT [PK_dbo.AspNetUsers] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Doctors]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Doctors](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](max) NOT NULL,
	[LastName] [nvarchar](max) NOT NULL,
	[DisplayName] [nvarchar](max) NULL,
	[User_ID] [nvarchar](128) NULL,
 CONSTRAINT [PK_dbo.Doctors] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Medications]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Medications](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[MedicationName] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_dbo.Medications] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Patients]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Patients](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](max) NOT NULL,
	[LastName] [nvarchar](max) NOT NULL,
	[DisplayName] [nvarchar](max) NULL,
	[UserID] [nvarchar](128) NULL,
 CONSTRAINT [PK_dbo.Patients] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

/****** Object:  Table [dbo].[PatientsDoctors]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[PatientsDoctors](
	[PatientID] [int] NOT NULL,
	[DoctorID] [int] NOT NULL,
 CONSTRAINT [PK_PatientsDoctors] PRIMARY KEY CLUSTERED 
(
	[PatientID] ASC,
	[DoctorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

/****** Object:  Table [dbo].[Prescriptions]    Script Date: 14/09/2015 14:46:15 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Prescriptions](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Directions] [nvarchar](max) NOT NULL,
	[Quantity] [int] NOT NULL,
	[Doctor_ID] [int] NOT NULL,
	[Medication_ID] [int] NOT NULL,
	[Patient_ID] [int] NOT NULL,
	[Appointment_ID] [int] NULL,
 CONSTRAINT [PK_dbo.Prescriptions] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

ALTER TABLE [dbo].[Appointments]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Appointments_dbo.Doctors_Doctor_ID] FOREIGN KEY([Doctor_ID])
REFERENCES [dbo].[Doctors] ([ID])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Appointments] CHECK CONSTRAINT [FK_dbo.Appointments_dbo.Doctors_Doctor_ID]
GO

ALTER TABLE [dbo].[Appointments]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Appointments_dbo.Patients_Patient_ID] FOREIGN KEY([Patient_ID])
REFERENCES [dbo].[Patients] ([ID])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Appointments] CHECK CONSTRAINT [FK_dbo.Appointments_dbo.Patients_Patient_ID]
GO

ALTER TABLE [dbo].[AspNetUserClaims]  WITH CHECK ADD  CONSTRAINT [FK_dbo.AspNetUserClaims_dbo.AspNetUsers_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[AspNetUsers] ([Id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[AspNetUserClaims] CHECK CONSTRAINT [FK_dbo.AspNetUserClaims_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[AspNetUserLogins]  WITH CHECK ADD  CONSTRAINT [FK_dbo.AspNetUserLogins_dbo.AspNetUsers_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[AspNetUsers] ([Id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[AspNetUserLogins] CHECK CONSTRAINT [FK_dbo.AspNetUserLogins_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[AspNetUserRoles]  WITH CHECK ADD  CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetRoles_RoleId] FOREIGN KEY([RoleId])
REFERENCES [dbo].[AspNetRoles] ([Id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[AspNetUserRoles] CHECK CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetRoles_RoleId]
GO

ALTER TABLE [dbo].[AspNetUserRoles]  WITH CHECK ADD  CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetUsers_UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[AspNetUsers] ([Id])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[AspNetUserRoles] CHECK CONSTRAINT [FK_dbo.AspNetUserRoles_dbo.AspNetUsers_UserId]
GO

ALTER TABLE [dbo].[Doctors]  WITH CHECK ADD  CONSTRAINT [FK_Doctors_AspNetUsers] FOREIGN KEY([User_ID])
REFERENCES [dbo].[AspNetUsers] ([Id])
GO

ALTER TABLE [dbo].[Doctors] CHECK CONSTRAINT [FK_Doctors_AspNetUsers]
GO

ALTER TABLE [dbo].[Patients]  WITH CHECK ADD  CONSTRAINT [FK_Patients_AspNetUsers] FOREIGN KEY([UserID])
REFERENCES [dbo].[AspNetUsers] ([Id])
GO

ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [FK_Patients_AspNetUsers]
GO

ALTER TABLE [dbo].[PatientsDoctors]  WITH CHECK ADD  CONSTRAINT [FK_PatientsDoctors_Doctors] FOREIGN KEY([DoctorID])
REFERENCES [dbo].[Doctors] ([ID])
GO

ALTER TABLE [dbo].[PatientsDoctors] CHECK CONSTRAINT [FK_PatientsDoctors_Doctors]
GO

ALTER TABLE [dbo].[PatientsDoctors]  WITH CHECK ADD  CONSTRAINT [FK_PatientsDoctors_Patients] FOREIGN KEY([PatientID])
REFERENCES [dbo].[Patients] ([ID])
GO

ALTER TABLE [dbo].[PatientsDoctors] CHECK CONSTRAINT [FK_PatientsDoctors_Patients]
GO

ALTER TABLE [dbo].[Prescriptions]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Prescriptions_dbo.Appointments_Appointment_ID] FOREIGN KEY([Appointment_ID])
REFERENCES [dbo].[Appointments] ([ID])
GO

ALTER TABLE [dbo].[Prescriptions] CHECK CONSTRAINT [FK_dbo.Prescriptions_dbo.Appointments_Appointment_ID]
GO

ALTER TABLE [dbo].[Prescriptions]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Prescriptions_dbo.Doctors_Doctor_ID] FOREIGN KEY([Doctor_ID])
REFERENCES [dbo].[Doctors] ([ID])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Prescriptions] CHECK CONSTRAINT [FK_dbo.Prescriptions_dbo.Doctors_Doctor_ID]
GO

ALTER TABLE [dbo].[Prescriptions]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Prescriptions_dbo.Medications_Medication_ID] FOREIGN KEY([Medication_ID])
REFERENCES [dbo].[Medications] ([ID])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Prescriptions] CHECK CONSTRAINT [FK_dbo.Prescriptions_dbo.Medications_Medication_ID]
GO

ALTER TABLE [dbo].[Prescriptions]  WITH CHECK ADD  CONSTRAINT [FK_dbo.Prescriptions_dbo.Patients_Patient_ID] FOREIGN KEY([Patient_ID])
REFERENCES [dbo].[Patients] ([ID])
ON DELETE CASCADE
GO

ALTER TABLE [dbo].[Prescriptions] CHECK CONSTRAINT [FK_dbo.Prescriptions_dbo.Patients_Patient_ID]
GO

