﻿global using System;
global using System.Collections.Generic;
global using System.Data.Common;
global using System.Linq;
global using System.Threading.Tasks;
global using AutoMapper;
global using Axity.Kafka;
global using Company.Project.Common.Mapping;
global using Company.Project.Persistence.Context;
global using Company.Project.Persistence.UnitOfWork;
global using Company.Project.Persistence.UnitOfWork.Impl;
global using Company.Project.Services.User;
global using Company.Project.Services.User.Impl;
global using Microsoft.Data.Sqlite;
global using Microsoft.EntityFrameworkCore;
global using Moq;
global using NUnit.Framework;
global using Company.Project.Model.Entities;
global using Company.Project.Common.DTOs.Requests.User;
global using Company.Project.Facade.Project;
global using Company.Project.Facade.Project.Impl;
global using Microsoft.EntityFrameworkCore.Diagnostics;
global using Company.Project.Common.DTOs.Responses.User;
global using Company.Project.Common.DTOs.Requests.Role;
global using Axity.Commons.Exceptions;