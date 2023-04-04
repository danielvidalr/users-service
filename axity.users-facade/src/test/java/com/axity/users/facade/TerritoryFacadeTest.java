package com.axity.users.facade;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.axity.users.commons.dto.TerritoryDto;
import com.axity.users.commons.request.PaginatedRequestDto;
import com.axity.users.commons.response.GenericResponseDto;
import com.axity.users.commons.response.PaginatedResponseDto;
import com.axity.users.facade.impl.TerritoryFacadeImpl;
import com.axity.users.service.TerritoryService;

/**
 * Class TerritoryFacadeTest
 * 
 * @author alejandro.menchaca@axity.com
 */
class TerritoryFacadeTest
{
  private TerritoryFacade territoryFacade;
  private TerritoryService territoryService;

  @BeforeEach
  public void setUp()
  {
    this.territoryFacade = new TerritoryFacadeImpl();

    this.territoryService = mock( TerritoryService.class );
    ReflectionTestUtils.setField( this.territoryFacade, "territoryService", this.territoryService );
  }

  /**
   * Test method for
   * {@link com.axity.users.facade.impl.TerritoryFacadeImpl#findTerritorys(com.axity.users.commons.request.PaginatedRequestDto)}.
   */
  @Test
  void testFindTerritorys()
  {
    int pageSize = 20;

    var data = new ArrayList<TerritoryDto>();
    for( int i = 0; i < pageSize; i++ )
    {
      data.add( this.createTerritory( i + 1 ) );
    }
    var paginated = new PaginatedResponseDto<TerritoryDto>( 0, pageSize, 50, data );
    when( this.territoryService.findTerritorys( any( PaginatedRequestDto.class ) ) ).thenReturn( paginated );

    var result = this.territoryFacade.findTerritorys( new PaginatedRequestDto( pageSize, 0 ) );
    assertNotNull( result );
  }

  /**
   * Test method for {@link com.axity.users.facade.impl.TerritoryFacadeImpl#find(java.lang.String)}.
   */
  @Test
  void testFind()
  {
    var response = new GenericResponseDto<TerritoryDto>( this.createTerritory( 1 ) );
    when( this.territoryService.find( anyInt() ) ).thenReturn( response );

    var result = this.territoryFacade.find( 1 );
    assertNotNull( result );
  }

  /**
   * Test method for
   * {@link com.axity.users.facade.impl.TerritoryFacadeImpl#create(com.axity.users.commons.dto.TerritoryDto)}.
   */
  @Test
  void testCreate()
  {
    var territory = this.createTerritory( 8 );
    var response = new GenericResponseDto<>( territory );
    when( this.territoryService.create( any( TerritoryDto.class ) ) ).thenReturn( response );

    var result = this.territoryFacade.create( territory );
    assertNotNull( result );
  }

  /**
   * Test method for
   * {@link com.axity.users.facade.impl.TerritoryFacadeImpl#update(com.axity.users.commons.dto.TerritoryDto)}.
   */
  @Test
  void testUpdate()
  {
    var territory = this.createTerritory( 1 );

    var response = new GenericResponseDto<>( true );
    when( this.territoryService.update( any( TerritoryDto.class ) ) ).thenReturn( response );
    var result = this.territoryFacade.update( territory );
    assertNotNull( result );
  }

  /**
   * Test method for {@link com.axity.users.facade.impl.TerritoryFacadeImpl#delete(java.lang.String)}.
   */
  @Test
  void testDelete()
  {
    var response = new GenericResponseDto<>( true );
    when( this.territoryService.delete( anyInt() ) ).thenReturn( response );

    var result = this.territoryFacade.delete( 9 );
    assertNotNull( result );
  }

  private TerritoryDto createTerritory( int i )
  {
    var territory = new TerritoryDto();
    territory.setId( i );
    return territory;
  }
}
