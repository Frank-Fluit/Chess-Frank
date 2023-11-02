import { Outlet, useLocation } from "react-router-dom";
import logo from "../assets/logo.jpg";
import { NavButton } from "../components/NavButton";
import backgroundImg from '../assets/chessImage.jpg';

export const RootLayout = () => {
    const { pathname } = useLocation();

    return <div className="flex flex-col h-screen ">
        <header className="bg-black shadow-lg flex flex-row p-4">

            <nav className="pt-4 flex-1 flex flex-row justify-center gap-2">


            </nav>
        </header>
        <main className="flex-1">
            <Outlet />
        </main>
    </div>
};
