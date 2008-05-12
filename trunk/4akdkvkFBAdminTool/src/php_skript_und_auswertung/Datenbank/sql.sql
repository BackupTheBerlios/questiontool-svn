USE [master]
GO
/****** Objekt:  Database [meinungsforschung]    Skriptdatum: 05/12/2008 13:40:10 ******/
CREATE DATABASE [meinungsforschung] ON  PRIMARY 
( NAME = N'meinungsforschung', FILENAME = N'C:\Programme\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\meinungsforschung.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'meinungsforschung_log', FILENAME = N'C:\Programme\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\meinungsforschung_log.ldf' , SIZE = 1280KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 COLLATE Latin1_General_CI_AS
GO
EXEC dbo.sp_dbcmptlevel @dbname=N'meinungsforschung', @new_cmptlevel=90
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [meinungsforschung].[dbo].[sp_fulltext_database] @action = 'disable'
end
GO
ALTER DATABASE [meinungsforschung] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [meinungsforschung] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [meinungsforschung] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [meinungsforschung] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [meinungsforschung] SET ARITHABORT OFF 
GO
ALTER DATABASE [meinungsforschung] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [meinungsforschung] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [meinungsforschung] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [meinungsforschung] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [meinungsforschung] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [meinungsforschung] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [meinungsforschung] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [meinungsforschung] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [meinungsforschung] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [meinungsforschung] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [meinungsforschung] SET  ENABLE_BROKER 
GO
ALTER DATABASE [meinungsforschung] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [meinungsforschung] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [meinungsforschung] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [meinungsforschung] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [meinungsforschung] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [meinungsforschung] SET  READ_WRITE 
GO
ALTER DATABASE [meinungsforschung] SET RECOVERY FULL 
GO
ALTER DATABASE [meinungsforschung] SET  MULTI_USER 
GO
ALTER DATABASE [meinungsforschung] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [meinungsforschung] SET DB_CHAINING OFF 