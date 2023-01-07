import { BrowserRouter, Navigate, useRoutes, RouteObject } from 'react-router-dom';
import Home from './Home';

const Routes = () => {
  const rootRoutes : RouteObject = {
    path: '/',
    element: <Navigate to="/main/home" />,
  }

  const noMatchRoutes: RouteObject = {
    path: '*',
    element: <Navigate to="/main/home" />,
  };

  const mainRoutes: RouteObject = {
    path: '/main',
    children: [
      {
        path: 'home',
        element: <Home />,
      },
    ],
  };
  const routes : RouteObject[] = [rootRoutes, noMatchRoutes, mainRoutes];
  
  return useRoutes(routes);
}
const Router = () => {
  return(
    <BrowserRouter>
      <Routes/>
    </BrowserRouter>
  )
}
export default Router;