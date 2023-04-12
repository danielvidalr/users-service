import { TestBed, inject } from '@angular/core/testing';

import { ColorsService } from './colors.service';
import { ConsumeService } from './consume.service';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { Endpoints } from 'src/environments/endpoints';
import { IColorsRes } from '../model/http/colors.model';
import { of, throwError } from 'rxjs';

declare var require: any;

describe('ColorsService', () => {
  let service: ColorsService;
  let consumeServiceSpy: jasmine.SpyObj<ConsumeService>;

  beforeEach(() => {
    consumeServiceSpy = jasmine.createSpyObj('ConsumeService', ['httpGet']);

    TestBed.configureTestingModule({
      imports: [],
      providers: [{ provide: ConsumeService, useValue: consumeServiceSpy }],
    });
    service = TestBed.inject(ColorsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should get colors', () => {
    const res: any = require('../../mocks/colors.json');
    consumeServiceSpy.httpGet.and.returnValue(of(res));

    service.getColors().subscribe((response) => {
      expect(response).toBeDefined();
      expect(response.page).toBe(1);
      expect(response.per_page).toBe(6);
      expect(response.total).toBe(12);
      expect(response.total_pages).toBe(2);
      expect(response.data).toBeTruthy(typeof Array);
    });
  });

  it('should get colors with error', () => {
    consumeServiceSpy.httpGet.and.returnValue(throwError(() => 'err'));

    service.getColors().subscribe({
      error: (err) => {
        expect(err).toBeDefined();
      },
    });
  });

  it('should get single color', () => {
    const res: any = require('../../mocks/color.json');
    consumeServiceSpy.httpGet.and.returnValue(of(res));

    service.getColor(1).subscribe((response) => {
      expect(response).toBeDefined();
      expect(response.data).toBeTruthy(typeof Object);
      expect(response.data.id).toBe(1);
      expect(response.data.name).toBe('cerulean');
      expect(response.data.year).toBe(2000);
      expect(response.data.color).toBe('#98B2D1');
      expect(response.data.pantone_value).toBe('15-4020');
    });
  });

  it('should get single color with error', () => {
    consumeServiceSpy.httpGet.and.returnValue(throwError(() => 'err'));

    service.getColor(1).subscribe({
      error: (err) => {
        expect(err).toBeDefined();
      },
    });
  });
});
